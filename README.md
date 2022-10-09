# This is a simple chat in Java using HttpServlet, without any authentication.
## BD connection:
1. Correct `ConnectionUtil` with your `URL`, `USERNAME`, `PASSWORD`, `JDBC_DRIVER`.
2. Database settings in file: `init_db.sql`
## How to use it:
1. Run your project.
2. Use url `http://localhost:8080/login`. Enter your `nickname` and click `Confirm`.
3. At the top of the screen you'll see the 50 previous messages 
(if they are already in the database).
Here you can write a message and `Send` it.
To update the messages, press the `Refresh` button.
