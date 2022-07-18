import { useState } from "react";
import "./Form.scss";

// form styles jacked from here
// https://codepen.io/banunn/pen/AFnal

const Form = () => {
  const [greeting, setGreeting] = useState({
    createdBy: "Charlie",
    greeting: "howdy",
    originCountry: "uk",
    nationality: "british",
  });

  const handleSubmit = async event => {
    event.preventDefault();

    const id = "id" + Math.random().toString(16).slice(2);

    const result = await fetch("http://localhost:8080/greeting", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({...greeting, id}),
    });

    const message = await result.text();

    alert(message);

    event.target.reset();
  };

  return (
    <div className="log-form">
      <h2>Add A New Greeting</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="your name"
          onInput={event => setGreeting({ ...greeting, createdBy: event.target.value })}
        />
        <input
          type="text"
          placeholder="greeting"
          onInput={event => setGreeting({ ...greeting, greeting: event.target.value })}
        />
        <input
          type="text"
          placeholder="origin country"
          onInput={event => setGreeting({ ...greeting, originCountry: event.target.value })}
        />
        <input
          type="text"
          placeholder="nationality"
          onInput={event => setGreeting({ ...greeting, nationality: event.target.value })}
        />
        <button type="submit" className="btn">
          Submit
        </button>
      </form>
    </div>
  );
};

export default Form;
