import React from "react";
import { Navbar } from "./Navbar";

var items = [
  { label: "Test", submenu: [{ label: "submenuTest", dest: "" }] },
  { label: "Test2", dest: "" },
  { label: "Movie", dest: "/movie" },
];

export const Header = () => {
  return (
    <>
      <Navbar items={items} />
    </>
  );
};
