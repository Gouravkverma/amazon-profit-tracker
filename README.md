Amazon Profit Tracker

Amazon Profit Tracker is a complete personal tool designed to automate the calculation of net profit from Amazon Seller Central orders.

It handles everything from scraping order data (Product, Size, Color, Quantity, Price) from Amazon Seller Central, to calculating profits by subtracting expenses like FBA fees, advertising costs, management fees, and storage charges. The results are then sent to a Spring Boot backend and optionally displayed via a React frontend.

---

🔧 Features

- Extracts today's orders from Amazon Seller Central (Unshipped or Shipped tab)
- Automatically pulls product details: name, color, size, quantity, price
- Calculates net profit using:
  - Total order profit
  - Management fees (₹ + 18% GST)
  - Amazon Ad Campaign fees
  - Amazon Monthly fees (in USD)
  - Storage fees (manual input)
- Uses Python (Selenium + BeautifulSoup) to automate browser scraping
- Sends data to a Java Spring Boot API
- React UI for manual input and testing
- MySQL database to persist all product & profit data

---

Technologies Used

Backend: Java, Spring Boot
Frontend: React.js
Scraping: Python, Selenium, BeautifulSoup
Database: MySQL
Version Control: Git, GitHub

---

Project Structure

```bash
amazon-profit-tracker/
├── backend/               # Java Spring Boot project
├── frontend/              # React UI to manually test profit inputs
├── scraper/               # Python script to automate data scraping
│   └── amazon_order_scraper.py
├── database/              # SQL dump or migration files
└── README.md              # Project description (this file)
```

---

How to Run the Project

📦 Backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run
```

Make sure MySQL is running and configured.

🌐 Frontend (React)

```bash
cd frontend
npm install
npm start
```

🤖 Python Scraper

```bash
cd scraper
python amazon_order_scraper.py
```

Make sure to place the correct chromedriver executable and update its path in the script.

---

🔐 Authentication

GitHub personal token is used for Git pushes. Password authentication is no longer supported.

---

Author

Gourav Verma

- [GitHub](https://github.com/Gouravkverma)
- Java Backend Developer | Automation Enthusiast

---

📜 License

This project is created for educational and personal use. Not intended for commercial resale or distribution.

---

✅ Status

🔄 In development — Basic features working. UI and more automation being added.

