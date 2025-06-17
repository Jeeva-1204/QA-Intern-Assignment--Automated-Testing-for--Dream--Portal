# QA Intern Assignment: Automated Testing for “Dream  Portal
 ### ✅ index.html — Dream Portal Home
- ✔ Loading animation appears and disappears after ~3 seconds.
- ✔ Main content and "My Dreams" button become visible.
- ✔ Clicking "My Dreams" opens:
  - `dreams-diary.html`
  - `dreams-total.html`
  in new tabs/windows.

### ✅ dreams-diary.html — Dream Log Table
- ✔ Contains exactly 10 dream entries.
- ✔ Dream Types are only **“Good”** or **“Bad”**.
- ✔ All rows have complete data: Name, Days Ago, and Type.

### ✅ dreams-total.html — Summary Page
- ✔ Correct statistics are shown:
  - Good Dreams: 6
  - Bad Dreams: 4
  - Total: 10
  - Recurring: 2
- ✔ Correctly detects recurring dreams:
  - **Flying over mountains**
  - **Lost in maze**

---

## 🧪 Automated Testing Setup

### 🔧 Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven (for dependencies)

