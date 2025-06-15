from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from bs4 import BeautifulSoup
import time
import requests
import json

# ------- CONFIGURATION ---------
CHROME_DRIVER_PATH = "chromedriver.exe"  # ChromeDriver should be in same folder or give full path
BACKEND_API_URL = "http://localhost:8080/api/save-orders"  # Spring Boot backend endpoint

# ------- SELENIUM SETUP ---------
options = Options()
options.add_experimental_option("detach", True)
driver = webdriver.Chrome(service=Service(CHROME_DRIVER_PATH), options=options)

# ------- STEP 1: OPEN AMAZON PAGE (you must be already logged in) ---------
driver.get("https://sellercentral.amazon.com/orders-v3/mfn/unshipped")

print("🔃 Waiting for orders to load...")
time.sleep(10)  # wait for data to load (can be adjusted)

# ------- STEP 2: PARSE HTML ---------
soup = BeautifulSoup(driver.page_source, 'html.parser')

# ------- STEP 3: SCRAPE ORDER DATA ---------
orders = []
order_rows = soup.find_all("div", class_="sc-list-item")  # update this class as per actual element

for row in order_rows:
    try:
        product_name = row.find("span", class_="product-title").text.strip()
        size = row.find("span", class_="product-size").text.strip()
        color = row.find("span", class_="product-color").text.strip()
        quantity = int(row.find("span", class_="product-quantity").text.strip())
        price = float(row.find("span", class_="product-price").text.strip().replace("$", ""))

        # Example profit calculation
        profit = round(price - (price * 0.15) - 600 - 150 - 30 - 1555, 2)  # ₹ values as INR fixed costs

        orders.append({
            "productName": product_name,
            "size": size,
            "color": color,
            "quantity": quantity,
            "price": price,
            "profit": profit
        })
    except Exception as e:
        print("⚠️  Error reading row:", e)

# ------- STEP 4: SEND TO BACKEND ---------
print(f"🚀 Sending {len(orders)} orders to backend...")

response = requests.post(BACKEND_API_URL, json=orders)
print("✅ Server response:", response.status_code, response.text)

# ------- FINISH ---------
driver.quit()
