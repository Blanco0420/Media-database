import React from "react";
import { FieldSetTemplate } from "./NewMovieForm";

const handleNewPerson = () => {};

const NewPerson = () => {
  return (
    <form
      action={handleNewPerson}
      className="p-5  text-white rounded-lg"
    ></form>
  );
};

export default NewPerson;
