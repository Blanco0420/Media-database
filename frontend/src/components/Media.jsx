import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { backendGetMedia } from "../utils/apiCalls";
import { MovieCard } from "./MovieCard";
import { useParams } from "react-router";
import { CustomRating } from "./CustomRating";
import { NavLink } from "react-router";

export const Media = () => {
  let { type, id } = useParams();

  const titles = {
    movie: "Movies",
    tv: "TV Shows",
    anime: "Anime",
  };
  // console.log(type);
  // let id = 1;
  const [mediaItems, setMediaItems] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const data = await backendGetMedia(type, id);
        setMediaItems(data);
      } catch (err) {
        setError(err);
      }
    };
    fetchData();
  }, [id, type]);
  // if (error) return <p>{error}</p>;
  return (
    <>
      <div className="flex p-4 bg-amber-800">
        <h1 className="text-center w-full text-5xl p-2">{titles[type]}</h1>
        <NavLink to={"new"} className="btn btn-accent">
          Add new
        </NavLink>
      </div>
      {mediaItems.length > 1 ? (
        <div className="">
          {/* TODO: make passing the mediaItems object easier instead of passing 2 different variables */}
          <div className="flex flex-col gap-4">
            {mediaItems.map((media) => (
              <MovieCard key={media.id} item={media} />
            ))}
          </div>
        </div>
      ) : mediaItems.length === 1 ? (
        <div>
          <MovieCard item={mediaItems[0]} />)
        </div>
      ) : (
        <div>Error, no media found</div>
      )}
    </>
  );
  // } else {
  //   return ;
  // }
};

// export default function Media() {
//

// axios.post(`${baseApiUrl}/movie/new`, {
// name: "Inceptionasdd",
// rating: 4.0,
// releaseDate: "11/02/1302",
// personRoles:[
//     {
//         role: "actor",
//         person: {
//             firstName: "Leonrassdsdo",
//             lastName: "Dicaprasdsio",
//             dob: "11/04/2034"
//         }
//     }
// ],
// // "watchStatus": "watching",
// "airingStatus": true,
// "genres": ["Comedy"]
// }).catch((err) =>{
//     switch(err.status){
//         case HttpStatusCode.Conflict:
//             console.log("Error, movie already exists");
//             break;
//     }
// });;
//     axios.get("http://localhost:8080/api/media/movie").then((res) =>{
//         console.log(res.data);
//         console.log(res.status)
//     }, [])

//   return (
//     <div>Media</div>
//   )
// }
