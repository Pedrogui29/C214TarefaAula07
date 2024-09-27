import smtplib
import os
from email.mime.text import MIMEText

# Getting email recipient from environment variable
email_username = os.getenv('EMAIL_USERNAME')
email_password = os.getenv('EMAIL_PASSWORD')
recipient = os.getenv('EMAIL_TO_NOTIFY')
pipeline_status = os.getenv('PIPELINE_STATUS')

if recipient:
    # Define email content
    msg_content = f'Pipeline executed with status: {pipeline_status}'
    msg = MIMEText(msg_content)
    msg['Subject'] = 'CI/CD Pipeline Notification'
    msg['From'] = email_username  # Insira seu email de envio aqui
    msg['To'] = recipient

    # Gmail SMTP setup
    try:
        server = smtplib.SMTP_SSL('smtp.gmail.com', 465)
        server.login(email_username, email_password)  # Use uma senha de app
        server.sendmail(email_username, recipient, msg.as_string())
        server.quit()
        print("Email sent successfully to", recipient)
    except Exception as e:
        print(f"Failed to send email: {str(e)}")
else:
    print("EMAIL_TO_NOTIFY is not set.")