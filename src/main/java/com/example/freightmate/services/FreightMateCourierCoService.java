package com.example.freightmate.services;

import com.example.freightmate.models.ConsignmentNoteNumberGenerator;

public class FreightMateCourierCoService {
	
	// this method for create consignment Note Number with parameter
    public String createConnoteIds(ConsignmentNoteNumberGenerator consignmentnote) {
        int previousAddress = consignmentnote.getLastUsedIndex();
        int digits = consignmentnote.getDigits();
        String consignmentnoteNum = "";
        if (previousAddress >= consignmentnote.getRangeStart() && previousAddress < consignmentnote.getRangeEnd()) {
            String prefix = getFirstCapitalLetterOfName(consignmentnote.getCarrierName());
            int currentIndex = previousAddress + 1;
            String consignmentAddress = String.format("%0" + digits + "d", currentIndex);
            int checkSum = checkSum(consignmentAddress, digits);
            consignmentnoteNum = prefix + consignmentnote.getAccountNumber() + consignmentAddress + String.valueOf(checkSum);
        } else {
        	consignmentnoteNum = "Last consignment Note Number not in Range " + consignmentnote.getRangeStart() + "-" + consignmentnote.getRangeEnd();
        }
        return consignmentnoteNum;
    }

    // this method for collect all Capital letters only
    private String getFirstCapitalLetterOfName(String carrierName) {
        char[] carrierNames = carrierName.toCharArray();
        String capitalLetters = "";
        for (int i = 0; i < carrierNames.length; i++) {
            if (Character.isUpperCase(carrierNames[i])) {
            	capitalLetters += carrierNames[i];
            }
        }
        return capitalLetters;
    }

    // This method for checksum of given consignment
    private int checkSum(String consignmentAddress, int digit) {
        int checkSum = 0;
        int firstCheckSum = 0;
        int secondCheckSum = 0;
        char[] consignmentChar = consignmentAddress.toCharArray();

        // Adding every second number in the index from the right starting at the first element
        for (int i = consignmentChar.length - 1; i >= 0; i = i - 2) {
            firstCheckSum += Integer.parseInt(String.valueOf(consignmentChar[i]));
        }

        // Adding every second number in the index from the right starting at the second element
        for (int i = consignmentChar.length - 2; i >= 0; i = i - 2) {
            secondCheckSum += Integer.parseInt(String.valueOf(consignmentChar[i]));
        }

        //Multiply that number by 7 or Multiply that number by 3 and Get the difference between that number and the next multiple of 10
        checkSum = Math.abs((digit * 10) - (firstCheckSum * 3 + secondCheckSum * 7));
        return checkSum;
    }

}
