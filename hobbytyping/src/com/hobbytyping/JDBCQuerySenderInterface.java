package com.hobbytyping;

public interface JDBCQuerySenderInterface {

    /**
     * Gets the current paragraph of the selected text for currently learning.
     * @param textName
     * @return
     */
    public String getParagraph(String textName);

    /**
     * Changes the value of a paragraph in a table after the previous paragraph has been correctly typed.
     * @param textName
     */
    public void setParagraph(String textName);

    /**
     * Gets a list of texts available for training.
     * @return
     */
    public String [] getTextList();

}
