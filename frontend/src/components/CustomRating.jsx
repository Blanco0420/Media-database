import { Rating } from "@smastrom/react-rating";
import { useEffect } from "react";
import { useState } from "react";

export const CustomRating = ({ _rating }) => {
  const [rating, setRating] = useState(_rating);

  // useEffect(() => {
  //   setRating(rating);
  // }, [rating]);

  return (
    <Rating style={{ maxWidth: 130 }} value={rating} onChange={setRating} />
  );
};
