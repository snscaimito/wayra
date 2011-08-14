When /^the RFID reader reads the RFID tags$/ do
  simulate_rfid_reading RFID_FILE, @trailer
  simulate_rfid_tagging RFID_FILE, @trailer_origin
end

Given /^there is a trailer loaded with "([^"]*)" boxes of "([^"]*)"$/ do |no_boxes, product|
  @trailer = []
  (1..no_boxes.to_i).each do |box|
    @trailer.push :id => "box-#{box}", :content => product
  end
end

When /^the trailer came from the "([^"]*)" field$/ do |origin|
  @trailer_origin = origin
end

Then /^all boxes are associated with the "([^"]*)" field$/ do |origin|
  box_tags = current_rfid_tags RFID_FILE

  box_tags.each do |box|
    box_origin = box['origin']
    fail "Incorrect origin tag. Expected #{origin} but got #{box_origin}" unless origin.eql?(box_origin)
  end
end

When /^the content tag for all boxes is "([^"]*)"$/ do |content|
  box_tags = current_rfid_tags RFID_FILE

  box_tags.each do |box|
    box_content = box['content']
    fail "Incorrect content tag. Expected #{content} but got #{box_content}" unless content.eql?(box_content)
  end
end

When /^"([^"]*)" boxes have been tagged$/ do |no_boxes|
  box_tags = current_rfid_tags RFID_FILE

  number_of_boxes = box_tags.size
  fail "Number of tagged boxes incorrect. Counted #{number_of_boxes} but expected #{no_boxes}" if number_of_boxes != no_boxes.to_i
end
