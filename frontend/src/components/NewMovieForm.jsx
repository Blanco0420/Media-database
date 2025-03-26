import React, { useState } from "react";
import { useParams } from "react-router";
import { CustomRating } from "./CustomRating";
import NewPerson from "./NewPerson";
import { FilteredPeople, UnfilteredPeople } from "./People";
import { useEffect } from "react";
import { backendGetPeople, backendPostMedia } from "../utils/apiCalls";
import axios from "axios";
import { FormProvider, useForm } from "./Context/FormContext";

// const test = (x) => {
//   console.log(x);
// };

export const FieldSetTemplate = ({ optional = false, label, children }) => {
  const [inputValue, setInputValue] = useState("");
  const [hasNoValue, setHasNoValue] = useState(false);
  const { formData, setFormData } = useForm();
  const handleChange = (e) => {
    // console.log(mediaItem.get("name"));
    // backendPostMedia;
    const value = e.target.value;
    setFormData((prev) => ({
      ...prev,
      [label]: value,
    }));
  };

  const handleInputChange = (e) => {
    const value = e.target.value;
    setInputValue(value);

    if (value === "") {
      setHasNoValue(true);
    } else {
      setHasNoValue(false);
    }
  };
  return (
    <>
      <fieldset className="fieldset p-2">
        <legend className="fieldset-legend">{label}</legend>
        {React.cloneElement(children, {
          onChange: handleChange,
          value: formData[label] || "",

          // value: inputValue,
          // onChange: handleInputChange,
          className: `${children.props.className} w-full min-h-9 ${
            hasNoValue ? `${children.type}-error` : ""
          }`,
        })}
        {optional && <div className="fieldset-label">Optional</div>}
        {hasNoValue && (
          <div className="fieldset-label">
            {label.toLowerCase()} is required
          </div>
        )}
      </fieldset>
    </>
  );
};

export const NewMovieForm = () => {
  let { type } = useParams();
  const [date, setDate] = useState();
  const [rating, setRating] = useState(0);
  const [people, setPeople] = useState([]);
  const [filteredPeople, setFilteredPeople] = useState([]);
  const { formData, setFormData } = useForm();

  useEffect(() => {
    const fetchData = async () => {
      try {
        let data = await backendGetPeople("actor");
        setPeople(data);
      } catch (err) {
        console.log(err);
      }
    };
    fetchData();
    // console.log("people: " + people);
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    backendPostMedia(formData);
  };

  return (
    <div className="grid grid-cols-3 grid-rows-2 p-6">
      {/* Form (spans 2 columns) */}
      <form
        onSubmit={handleSubmit}
        className="col-span-2 flex flex-col gap-4 bg-gray-700 p-6 rounded-xl shadow-lg"
      >
        {/* Name Field */}
        <FieldSetTemplate label={"Name"}>
          <input className="input w-full" type="text" />
        </FieldSetTemplate>
        {/* Description Field */}
        <FieldSetTemplate label={"Description"} optional={true}>
          <textarea className="textarea min-h-24 w-full"></textarea>
        </FieldSetTemplate>
        <div className="grid grid-cols-2 gap-4">
          {/* Release Date */}
          <FieldSetTemplate label={"Release Date"}>
            <input type="date" className="input w-full" />
          </FieldSetTemplate>
          {/* Rating */}
          <div className="flex flex-col">
            <label className="text-white mb-1">Rating</label>
            <CustomRating rating={rating} setRating={setRating} />
          </div>
        </div>
        {/* Buttons */}
        <div className="flex gap-4">
          <button className="btn btn-error flex-1" type="reset">
            Reset
          </button>
          <button className="btn btn-primary flex-1">Create Movie</button>
        </div>
        <FilteredPeople
          people={filteredPeople}
          setPeople={setFilteredPeople}
          unfilteredPeople={people}
          setUnfilteredPeople={setPeople}
        />
      </form>

      {/* People Selection (1 column) */}
      <div className="flex flex-col gap-4">
        <UnfilteredPeople
          people={people}
          setPeople={setPeople}
          filteredPeople={filteredPeople}
          setFilteredPeople={setFilteredPeople}
        />
        <NewPerson />
      </div>
    </div>
  );
};
