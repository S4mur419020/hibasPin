package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PinModell {
    private StringBuilder pin=new StringBuilder();
    private final int PIN_HOSSZ=4;
    
    public boolean addDigit(char digit){
         if (pin.length() < PIN_HOSSZ && Character.isDigit(digit)) {
            pin.append(digit);
            return true;
        }
        return false;
    }
    public boolean isComplete(){
        return pin.length()==PIN_HOSSZ;
    }
    
    public String getPin(){
        return pin.toString();
    }
    
    public void ujra(){
        pin.setLength(0);
    }
    
    public void saveToFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        Files.write(path, pin.toString().getBytes(StandardCharsets.UTF_8));
    }
}
