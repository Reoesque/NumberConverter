# NumberConverter
A matriculation number converter that I use for work. It basically just converts numbers between multiple formats, so that I can quickly copy a specific format.

## Prerequisites
* This program was created using OpenJDK 17.
* No additional libraries or extensions necessary. Just make sure to have a Java Runtime Environment installed.

### Installing Java
#### Windows
* [Installing Java on Windows 10 and higher](https://www.java.com/en/download/help/windows_manual_download.html)

#### Linux
* [Arch](https://wiki.archlinux.org/title/java):

```
sudo pacman -S java-runtime-common
```

* [Ubuntu](https://ubuntu.com/tutorials/install-jre) (Only Step 1 and 2 necessary; no need for Oracle HotSpot JRE)

```
sudo apt install default-jre
```

#### macOS
* [Installing Java on macOS](https://www.java.com/en/download/help/mac_install.html)
* Otherwise you can install Java using brew:

```
brew cask install java
```

## Running the Application
* For running NumberConverter, simply run the `NumberConverter.jar`-File.

### Windows
* Right-click on the `NumberConverter.jar`-File and open it using `Java Runtime Environment`
* Alternatively using the Windows Terminal, PowerShell or the Command Prompt:
1. Go to the directory where you have the `NumberConverter.jar`-File saved (by using `cd c:\PATH\`)
2. Run the jar-File by entering `java.exe -jar NumberConverter.jar`

### Linux / macOS
* Running the `NumberConverter.jar`-File:
```
java -jar /path/to/NumberConverter.jar
```

## Main Window
![](/images/mainwindow.png)
* Upper most elements: Input field for whatever format. 
* Convert the input matriculation number (and fill up the text fields below) by either pressing enter whilst still having the cursor inside the input field or by clicking the `Convert` button.
* You can then copy the converted number into your clipboard by clicking on the respective `Copy` button next to the desired format text field.
* You can also clear our all text fields by clicking on `Clear All`
* Additionally you can also clear your clipboard by clicking on `Empty Clipboard`