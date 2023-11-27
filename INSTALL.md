# Installation
Choose one of the following methods to install this program:

## Method 1: Direct Download
### Download the Installer
Download the program from the releases directory, or [Click Here](releases/timer-install.zip) for a direct download.

### Install on Windows
1. Unzip the folder to a convenient location, such as your Downloads folder.
2. Double-click `install.bat` to initiate the installation. This will copy the files into the `C:\Timer` directory.
3. Optional (Recommended): Add the `C:\Timer` entry to the `PATH` environment variable:
   * Search for "Environment Variables" in Windows Search and select the first option.
   * Click the "Environment Variables..." button (bottom right).
   * Select the variable named "PATH" and click "Edit."
   * Press "New," enter the value C:\Timer, and click OK, then exit.

Now, you can run `timer 10s` from your command prompt.

### Install on Linux
1. Unzip the folder to an accessible location, like your Downloads folder.
2. Run the following command: `.\install.sh`
3. Test your installation by running: timer 10s. You may need to restart your terminal.

## Method 2: Manual Install

### Prerequisites
* [A recent'ish version of Java](https://www.azul.com/downloads/?version=java-21-lts&package=jre-fx#zulu)
* [Gradle](https://gradle.org/)
* [Git](https://git-scm.com/)

### Installation Steps
1. Clone the repository: `git clone https://github.com/surajkumar/countdown-timer-overlay-app.git`
2. Navigate to the project directory:  `cd countdown-timer-overlay-app`
3. Run `gradle build`
4. The `countdown-timer-overlay-app.jar` will be installed
5. Rename the file and add the path to your `PATH` environment variable for easy access.

