import { Rating } from "@smastrom/react-rating";

export const CustomRating = ({ rating, setRating }) => {
  // const [rating, setRating] = useState(_rating);

  // useEffect(() => {
  //   setRating(rating);
  // }, [rating]);
  return (
    <Rating
      style={{ maxWidth: 200 }}
      spaceBetween={"small"}
      value={rating}
      onChange={setRating}
    />
  );
};
