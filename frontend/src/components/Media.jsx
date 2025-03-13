import axios, { HttpStatusCode } from "axios";
import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { backendGet } from "../utils/apiCalls";
import { MovieCard } from "./MovieCard";
import movieBanner from "../assets/movieBanner.jpg";
import { useParams } from "react-router";
import { CustomRating } from "./CustomRating";


export const Media = () => {
  let { type, id } = useParams();
  // console.log(type);
  // let id = 1;
  const [mediaItems, setMediaItems] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const data = await backendGet(type, id);
        setMediaItems(data);
      } catch (err) {
        setError(err);
      }
    };
    fetchData();
  }, [id, type]);
  // if (error) return <p>{error}</p>;
   if(mediaItems.length > 1){
  return (
    <div>
      {/* TODO: make passing the mediaItems object easier instead of passing 2 different variables */}
      {mediaItems.length > 1 ? (
        mediaItems.map((media) => (
          <div className="mb-4 last:mb-0">
            <MovieCard item={media}></MovieCard>
          </div>
        ))
      ) : (
        <MovieCard item={mediaItems} />
      )}
    </div>
  );
} else{
  return <div>Error, no media found</div>
}
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
