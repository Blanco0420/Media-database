import React from "react";
import { Navbar } from "./Navbar";

var items = [
  { label: "Test", submenu: [{ label: "submenuTest" }] },
  { label: "Test2" },
];

export const Header = () => {
  return (
    <>
      <Navbar items={items} />
    </>
  );
};
