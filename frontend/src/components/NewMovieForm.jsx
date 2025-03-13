import React, { useState } from "react";
import { useParams } from "react-router";
import { CustomRating } from "./CustomRating";

// const test = (x) => {
//   console.log(x);
// };

export const NewMovieForm = () => {
  let { type } = useParams();
  const [date, setDate] = useState();

  return (
    <>
      <form className="p-5 flex flex-col items-center bg-gray-800 text-white rounded-lg">
      {/* Movie Name */}
      <div className="">
        <label htmlFor="name" className="whitespace-nowrap">Movie Name:</label>
        <input type="text" id="name" className="input bg-gray-700 p-2 rounded" required />
      </div>

      {/* Release Date */}
      <div className="">
        <label htmlFor="releaseDate" className="whitespace-nowrap">Release Date:</label>
        <input type="date" id="releaseDate" className="input bg-gray-700 p-2 rounded" required />
      </div>

      {/* Rating */}
      {/* <div className="items-center space-x-2">
        <label htmlFor="rating" className="whitespace-nowrap">Rating:</label>
        <input type="number" id="rating" className="input bg-gray-700 p-2 rounded w-16" required />
      </div> */}
    <CustomRating />
      {/* Buttons */}
      <div className="space-x-2">
        <button className="text-red-500 hover:underline" type="reset">Reset fields</button>
        <button className="bg-blue-500 px-4 py-2 rounded text-white">Create new movie</button>
      </div>
    </form>
    </>
  );
};
