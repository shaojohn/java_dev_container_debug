# Hello World Spring Boot API

A simple Spring Boot REST API application with debugging support in VS Code dev containers.

## Prerequisites

- Docker
- Visual Studio Code with Dev Containers extension

## Getting Started

### 1. Open in Dev Container

1. Open this folder in VS Code
2. When prompted, click "Reopen in Container" (or use Command Palette: `Dev Containers: Reopen in Container`)
3. Wait for the container to build and dependencies to install

### 2. Run the Application

#### Option A: Using Terminal
```bash
mvn spring-boot:run
```

#### Option B: Using VS Code Tasks
Press `Ctrl+Shift+P` (or `Cmd+Shift+P` on Mac) and select `Tasks: Run Task` → `spring-boot:run`

The application will start on `http://localhost:8888`

### 3. Test the API

Open your browser or use curl:
```bash
curl http://localhost:8888/
```

Expected response: `Hello World! Current server time is: [timestamp]`

## Debugging with Breakpoints

### Method 1: Direct Debug Launch (Recommended)

1. **Open a Java file** (e.g., `src/main/java/com/example/helloworldapi/controller/HelloWorldController.java`)

2. **Set a breakpoint**:
   - Click on the left margin (line number gutter) next to the line where you want to pause
   - A red dot will appear indicating the breakpoint is set
   - Example: Set a breakpoint on line 15 in `HelloWorldController.java` (the `return greeting;` line)

3. **Start debugging**:
   - Press `F5` (or click Run → Start Debugging)
   - Select **"Debug Spring Boot App"** from the configuration dropdown if prompted
   - Wait for the application to start (you'll see debug controls appear at the top)

4. **Trigger the breakpoint**:
   - Open your browser or use curl to hit the endpoint:
     ```bash
     curl http://localhost:8888/
     ```
   - The debugger will pause at your breakpoint
   - You can now:
     - Inspect variables in the Variables panel
     - Step through code using the debug toolbar (Step Over, Step Into, Step Out)
     - View the call stack
     - Evaluate expressions in the Debug Console

5. **Continue execution**:
   - Press `F5` or click the Continue button to resume

### Method 2: Attach to Running Process

If you already have the app running and want to attach the debugger:

1. **Start the app with debug enabled**:
   ```bash
   mvn spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
   ```

2. **Attach the debugger**:
   - Press `Ctrl+Shift+D` to open the Run and Debug view
   - Select **"Attach to Remote Spring Boot"** from the dropdown
   - Press `F5` or click the green play button

3. **Set breakpoints and test** as described above

## Debug Configuration

The project includes pre-configured debug settings in `.vscode/launch.json`:

- **Debug Spring Boot App**: Launches the application in debug mode
- **Attach to Remote Spring Boot**: Attaches to an already running application on port 5005

## Project Structure

```
.
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/helloworldapi/
│       │       ├── HelloWorldApiApplication.java    # Main application class
│       │       └── controller/
│       │           └── HelloWorldController.java    # REST controller
│       └── resources/
│           └── application.properties
├── pom.xml                                          # Maven configuration
└── .devcontainer/                                   # Dev container configuration
```

## Ports

- `8888`: Spring Boot application
- `5005`: Java debug port (JDWP)

## Technology Stack

- Java 21
- Spring Boot 3.4.0
- Maven 3.9.6

## Troubleshooting

### Breakpoints not working?
- Ensure you started the app using the debug configuration (F5), not just `mvn spring-boot:run`
- Check that the red dot appears solid (not hollow) when you set a breakpoint
- Verify the Java extension pack is installed and active

### Port already in use?
```bash
# Find and kill the process using port 8888
lsof -ti:8888 | xargs kill -9
```

### Application won't start?
```bash
# Clean and rebuild
mvn clean install
```

## Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [VS Code Java Debugging](https://code.visualstudio.com/docs/java/java-debugging)
- [Maven Documentation](https://maven.apache.org/)
