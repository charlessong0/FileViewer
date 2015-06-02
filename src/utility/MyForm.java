package utility;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MyForm {

    // Init ---------------------------------------------------------------------------------------

    private String text;
    private File file;
    private String[] check;
    private Map<String, Boolean> checked = new HashMap<String, Boolean>();
    private Map<String, String> errors = new HashMap<String, String>();
    private Map<String, String> messages = new HashMap<String, String>();

    // Getters ------------------------------------------------------------------------------------

    public String getText() {
        return text;
    }

    public File getFile() {
        return file;
    }

    public String[] getCheck() {
        return check;
    }

    // Setters ------------------------------------------------------------------------------------

    public void setText(String text) {
        this.text = text;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setCheck(String[] check) {
        checked = new HashMap<String, Boolean>();
        for (String value : check) {
            checked.put(value, Boolean.TRUE);
        }
        this.check = check;
    }

    // Helpers ------------------------------------------------------------------------------------

    public Map<String, Boolean> getChecked() {
        return checked;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setError(String fieldName, String message) {
        errors.put(fieldName, message);
    }

    public void setMessage(String fieldName, String message) {
        messages.put(fieldName, message);
    }

    public boolean hasErrors() {
        return errors.size() > 0;
    }

}