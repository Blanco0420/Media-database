import { Rating } from "@smastrom/react-rating";

export const CustomRating = ({ value, onChange }) => {
  // const [rating, setRating] = useState(_rating);

  // useEffect(() => {
  //   setRating(rating);
  // }, [rating]);
  return (
    <Rating
      style={{ maxWidth: 200 }}
      spaceBetween={"small"}
      value={value}
      onChange={(value) => onChange(value)}
    />
  );
};
