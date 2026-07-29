const API_URL = "http://localhost:8081";

async function apiRequest(url, method = "GET", data = null) {

    const options = {
        method: method,
        headers: {
            "Content-Type": "application/json"
        }
    };

    if (data) {
        options.body = JSON.stringify(data);
    }

    try {

        const response = await fetch(API_URL + url, options);

        let result = {};

        try {
            result = await response.json();
        } catch (e) {
            result = {};
        }

        if (!response.ok) {
            console.log("Backend Error:", result);

            throw new Error(
                result.message ||
                result.error ||
                "Server Error"
            );
        }

        return result;

    } catch (err) {

        console.error(err);

        throw new Error("Cannot connect to Spring Boot Server");

    }

}
