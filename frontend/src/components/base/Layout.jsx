import React from "react";
import { Header } from "./HeaderFooter";
import { Outlet } from "react-router";

export const Layout = () => {
  return (
    <>
      <Header />
      <div className="flex flex-1 items-center justify-center">
        <main className="w-10/12 rounded-md bg-gray-700 shadow-lg">
          <Outlet />
        </main>
      </div>
    </>
  );
};
