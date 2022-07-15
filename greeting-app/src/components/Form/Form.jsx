import { useState } from "react";
import "./Form.scss";

// form styles jacked from here
// https://codepen.io/banunn/pen/AFnal

const Form = () => {
  const [greeting, setGreeting] = useState({
    createdBy: "",
    greeting: "",
    originCountry: "",
    nationality : ""
  })

  const handleSubmit = (event) => {
    event.preventDefault()
    // SEND POST REQUEST?
    event.target.reset();
  }

  return (
    <div className="log-form">
      <h2>Add A New Greeting</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" placeholder="your name" onInput={(event) => setGreeting({ ...greeting, createdBy: event.target.value })} />
        <input type="text" placeholder="greeting" onInput={(event) => setGreeting({ ...greeting, greeting: event.target.value })} />
        <input type="text" placeholder="origin country" onInput={(event) => setGreeting({ ...greeting, originCountry: event.target.value })} />
        <input type="text" placeholder="nationality" onInput={(event) => setGreeting({ ...greeting, nationality: event.target.value })} />
        <button type="submit" className="btn">Submit</button>
      </form>
    </div>
  );
}

export default Form;