module RFIDSimulator

  def simulate_rfid_reading(rfid_file_name, tags)
    File.open(rfid_file_name, "w+") do |rfid_file|
      rfid_file.write(JSON tags)
      rfid_file << "\n"
    end
  end

  def current_rfid_tags(rfid_file_name)
    File.open(rfid_file_name, "r") { |rfid_file| JSON.parse rfid_file.read }
  end

  def simulate_rfid_tagging(rfid_file, origin)
    system("java -jar wayra-core/target/wayra-core-0.0.1-SNAPSHOT-jar-with-dependencies.jar #{rfid_file} #{origin}")
  end

end

World(RFIDSimulator)

