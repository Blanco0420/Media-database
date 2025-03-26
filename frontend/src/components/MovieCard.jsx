import React from "react";
import { CustomRating } from "./CustomRating";
import image from "../assets/movieBanner.jpg";
import { Check } from "lucide-react";
import { X } from "lucide-react";
import { Eye } from "lucide-react";
import { Clock } from "lucide-react";
import { Star } from "lucide-react";

const statusColors = {
  watching: {
    statusName: "Watching",
    bg: "bg-blue-500",
    icon: <Clock size={20} />,
  },
  completed: {
    statusName: "Completed",
    bg: "bg-green-500",
    icon: <Check size={20} />,
  },
  dropped: { statusName: "Dropped", bg: "bg-red-500", icon: <X size={20} /> },
  wantToWatch: {
    statusName: "Want to watch",
    bg: "bg-yellow-500",
    icon: <Star size={20} />,
  },
};

export const MovieCard = ({item }) => {
  const { name, description, rating, watchStatus } = item;
  const { statusName, bg, icon } = statusColors[watchStatus] || {
    bg: "bg-gray-500",
    icon: null,
  };
  return (
    <div className="card card-side bg-gray-400 shadow-sm">
      <div className="">
        <figure className="border-2 rounded-2xl max-w-48">
          <img src={image} alt={name} />
        </figure>
      </div>
      <div className="card-body">
        <div className="flex justify-between items-center">
          <h2 className="text-3xl">{name}</h2>
          <div
            className={`${bg} flex items-center gap-2 p-2 text-white rounded-md`}
          >
            {icon} <span>{statusName}</span>
          </div>
        </div>
        <p>{description}</p>
        <div className="card-actions flex justify-between items-center">
          <CustomRating rating={rating} />
          <button className="btn">Watch now</button>
        </div>
      </div>
    </div>
  );
};
