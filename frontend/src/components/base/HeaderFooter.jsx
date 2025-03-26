import React from "react";
import { Navbar } from "./Navbar";

var items = [
  {
    label: "Media",
    submenu: [
      { label: "Movies", dest: "/movie" },
      { label: "TV", dest: "/tv" },
      { label: "Anime", dest: "/anime" },
    ],
  },
  // { label: "New Media", dest: ":typ/new" },
  { label: "Movie", dest: "/movie" },
];

export const Header = () => {
  return (
    <>
      <Navbar items={items} />
    </>
  );
};
