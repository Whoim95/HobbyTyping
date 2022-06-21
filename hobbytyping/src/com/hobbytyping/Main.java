package com.hobbytyping;

/**
 * To test methods, uncomment the desired call.
 */

public class Main {

    public static void main(String[] args) {

        JDBCQuerySender query = new JDBCQuerySender();
        JDBCQuerySenderInterface queryInterface;

        queryInterface = query;

        //System.out.println(queryInterface.getParagraph("'Who gets what?'"));

        //queryInterface.setParagraph("'Who gets what?'");

/*      String [] listNew = new String[10];

        listNew = query.getTextList();

        for (int n = 0; n < listNew.length; n++) {
           if (listNew[n] != null) {
               System.out.println(listNew[n]);
           }
       }
*/
    }
}
