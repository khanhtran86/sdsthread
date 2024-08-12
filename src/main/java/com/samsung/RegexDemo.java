package com.samsung;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class RegexDemo
{
    public static void main2( String[] args )
    {
        String fileName = "FR_Q4_2022.pdf";
        //Define regex pattern
        Pattern fileNamePattern = Pattern.compile("FR_([HQ]\\d).+(\\d{4})\\.pdf");

        //Define matcher
        Matcher fileNameMatcher = fileNamePattern.matcher(fileName);

        //matcher.find() - Chi dung de check xem du lieu co match hay khong thoi
        if(fileNameMatcher.matches())
        {
            String type = fileNameMatcher.group(1); //
            String year = fileNameMatcher.group(2);

            System.out.println(type);
            System.out.println(year);
        }

    }

    private static int extractDataForSort(String fileName)
    {
        Pattern fileNamePattern = Pattern.compile("FR_([HQ]\\d).+(\\d{4})\\.pdf");
        Matcher fileNameMatcher = fileNamePattern.matcher(fileName);
        if(fileNameMatcher.matches())
        {
            String type = fileNameMatcher.group(1);
            String year = fileNameMatcher.group(2);

            //match type to number
            int type2Number = 0;
            switch (type.toLowerCase())
            {
                case "h2":
                    type2Number = 4;
                    break;
                case "q3":
                    type2Number=3;
                    break;
                case "h1":
                    type2Number=2;
                    break;
                case "q1":
                    type2Number = 1;
                    break;
            }

            return Integer.parseInt(year+type2Number);
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> lstFiles =Arrays.asList(
                "FR_Q1_2022.pdf", "FR_H2_2023.pdf", "FR_Q3_2023.pdf", "FR_H1_2022.pdf", "FR_H1_2023.pdf", "FR_Q1_2023.pdf","FR_H2_2022.pdf"
                );

        lstFiles.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return extractDataForSort(o2) - extractDataForSort(o1);
            }
        });

        lstFiles.forEach((s)-> System.out.println(s));
    }
}
