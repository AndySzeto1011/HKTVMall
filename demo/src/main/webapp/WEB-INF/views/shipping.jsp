<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shipping Fee Calculator</title>
    <script>
        async function calculateShipping() {
            const length = document.getElementById("length").value;
            const width = document.getElementById("width").value;
            const height = document.getElementById("height").value;
            const weight = document.getElementById("weight").value;
            const temperature = document.getElementById("temperature").value;
            const quantity = document.getElementById("quantity").value;

            const requestBody = [{
                length: parseFloat(length),
                width: parseFloat(width),
                height: parseFloat(height),
                weight: parseFloat(weight),
                temperature: temperature,
                quantity: parseInt(quantity)
            }];

            const response = await fetch("/api/shipping/calculate", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(requestBody)
            });

            const data = await response.json();
            document.getElementById("result").innerText = "Total Shipping Fee: HKD " + data.total_shipping_fee;
        }
    </script>
</head>
<body>
    <h2>Shipping Fee Calculator</h2>
    <form type="post" onsubmit="event.preventDefault(); calculateShipping();">
        <label>Length (cm): <input type="number" id="length" required></label><br>
        <label>Width (cm): <input type="number" id="width" required></label><br>
        <label>Height (cm): <input type="number" id="height" required></label><br>
        <label>Weight (kg): <input type="number" id="weight" required></label><br>
        <label>Temperature Condition:
            <select id="temperature">
                <option value="Ambient">Ambient</option>
                <option value="Chill">Chill</option>
            </select>
        </label><br>
        <label>Quantity: <input type="number" id="quantity" required></label><br>
        <button type="submit">Calculate</button>
    </form>
    <h3 id="result"></h3>
</body>
</html>
