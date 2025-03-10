import { Rating } from "@smastrom/react-rating";
import { useEffect } from "react";
import { useState } from "react";

export const CustomRating = ({ rating }) => {
  const [_rating, setRating] = useState(null);

  useEffect(() => {
    setRating(rating);
  }, [rating]);

  return (
    <Rating style={{ maxWidth: 130 }} value={rating} onChange={setRating} />
  );
};
