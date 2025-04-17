# Simple Rasa Chatbot with Spring Boot

This project integrates a Rasa chatbot with a Spring Boot backend, allowing users to interact with the chatbot via a simple web interface. The frontend consists of a clean and user-friendly chat UI, and the backend handles the communication between the user and the Rasa model.

## Features
- **Interactive Web Interface**: A responsive chat interface where users can send messages and get responses from the Rasa bot.
- **Spring Boot Backend**: The backend handles the logic for sending user messages to the Rasa server and receiving responses.
- **Clear Chat**: Users can clear the chat history to start a fresh conversation.
  
## Technologies Used
- **Frontend**: HTML, CSS, JavaScript (Vanilla)
- **Backend**: Spring Boot (Java)
- **Rasa**: A conversational AI framework
- **Build Tool**: Maven

## Requirements

- **Java 17 or higher** (For Spring Boot)
- **Maven** (For dependency management and building the project)
- **Rasa server** running locally (or accessible from your backend) on port `5005` with the `/webhooks/rest/webhook` endpoint for processing messages.

## Setup Instructions

### Backend (Spring Boot)
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/simple-rasa-chatbot.git
   cd simple-rasa-chatbot
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Ensure that the Rasa server is running locally or accessible through the provided URL (`http://localhost:5005/webhooks/rest/webhook`).

4. Start the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```
   By default, the Spring Boot application will run on port `8080`.

### Frontend (Web Interface)
The frontend is a static HTML file that interacts with the backend through a REST API (`/api/chat`). You can place the `index.html` file in the `src/main/resources/static` directory or simply serve it from any web server of your choice.

Make sure that your backend is running on `localhost:8080` (or adjust the fetch URL in the frontend code to match the backend host).

### Rasa Setup

1. Install **Rasa** and train a chatbot model:
   ```bash
   pip install rasa
   rasa init
   ```

2. Start the Rasa server locally on port `5005`:
   ```bash
   rasa run --cors "*" --enable-api
   ```

3. Test the Rasa server by sending a message:
   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{"sender": "user", "message": "Hello"}' http://localhost:5005/webhooks/rest/webhook
   ```

Make sure your Rasa model is trained and running before using this chatbot.

## How It Works

1. **Frontend**: The user types a message in the input box and clicks "Send".
2. **Backend**: The Spring Boot application sends the message to the Rasa server via a `POST` request to the `/webhooks/rest/webhook` endpoint.
3. **Rasa**: The Rasa server processes the message, generates a response, and sends it back to the Spring Boot backend.
4. **Response**: The backend then sends the bot's response back to the frontend, where it is displayed in the chat window.

## How to Clear Chat

You can clear the chat history by clicking the **"Clear Chat"** button. This will remove all messages from the chat window, allowing you to start a fresh conversation.

## Troubleshooting

- Ensure that both the Spring Boot backend and Rasa server are running and accessible.
- If you encounter any errors related to Rasa, check the Rasa logs for detailed error messages.
- If your backend is not responding, ensure the URL in the fetch request matches the actual URL where your backend is running.

## Contributing

Feel free to fork the repository, submit pull requests, or open issues. Contributions are welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

### Architecture Diagram

Below is a simple diagram showing the interaction between the user, frontend, backend, and Rasa server:

```
   +------------------+      +-------------------+      +------------------+
   |                  |      |                   |      |                  |
   |     User         +----->|    Frontend       +----->|    Backend       |
   |  (Web Interface) |      |  (HTML, JS, CSS)  |      |   (Spring Boot)  |
   |                  |      |                   |      |                  |
   +------------------+      +-------------------+      +--------+---------+
                                                             |
                                                     +-------v-------+
                                                     |               |
                                                     |     Rasa     |
                                                     |  (Chatbot)   |
                                                     |               |
                                                     +---------------+
```

### Description:
- **User**: Interacts with the chatbot through the web interface (frontend).
- **Frontend**: HTML, CSS, and JavaScript (Vanilla) are used to create a simple chat UI. It sends user messages to the backend via a REST API.
- **Backend**: Spring Boot application that receives user messages from the frontend, communicates with the Rasa server, and returns responses to the frontend.
- **Rasa**: The AI-based chatbot framework that processes user messages and generates responses.

---
