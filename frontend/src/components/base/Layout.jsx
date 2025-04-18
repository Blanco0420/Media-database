import React from "react";
import { Header } from "./HeaderFooter";
import { Outlet } from "react-router";

export const Layout = () => {
  return (
    <>
      <Header />
      <div className="flex flex-1 items-center justify-center">
        <main className="w-11/12 rounded-md shadow-lg">
          <Outlet />
        </main>
      </div>
    </>
  );
};
