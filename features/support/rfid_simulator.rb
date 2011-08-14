module RFIDSimulator

  def simulate_rfid_reading_and_tagging(rfid_file, origin)
    system("java -jar wayra-core/target/wayra-core-0.0.1-SNAPSHOT-jar-with-dependencies.jar #{rfid_file} #{origin}")
  end

end

World(RFIDSimulator)

