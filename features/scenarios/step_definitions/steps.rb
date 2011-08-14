When /^the RFID reader reads the RFID tags$/ do
  fail "No trailer load data" if @trailer.nil?

  File.open(RFID_FILE, "w+") do |rfid_file|
    rfid_file.write(JSON @trailer)
    rfid_file << "\n"
  end

  simulate_rfid_reading_and_tagging RFID_FILE, @trailer_origin
end

Given /^there is a trailer loaded with "([^"]*)" boxes of "([^"]*)"$/ do |no_boxes, product|
  @trailer = []
  (1..20).each do |box|
    @trailer.push :id => "box-#{box}", :content => product
  end
end

When /^the trailer came from the "([^"]*)" field$/ do |origin|
  @trailer_origin = origin
end

Then /^all "([^"]*)" boxes are associated with the "([^"]*)" field$/ do |no_boxes, origin|
  File.open(RFID_FILE, "r") do |rfid_file|
    tagged_boxes = JSON.parse rfid_file.read

    box_number = 0
    tagged_boxes.each do |box|
      box_origin = box['origin']
      fail "Incorrect origin tag. Expected #{origin} but got #{box_origin}" unless origin.eql?(box_origin)
      box_number = box_number + 1
    end

    fail "Number of tagged boxes incorrect. Counted #{box_number} but expected #{no_boxes}" if box_number != no_boxes.to_i
  end
end
