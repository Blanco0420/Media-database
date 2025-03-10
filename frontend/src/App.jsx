import "./App.css";
import { Layout } from "./components/base/Layout";
import { Header } from "./components/base/HeaderFooter";
import { Navbar } from "./components/base/Navbar";
import { Media } from "./components/Media";
import { Router } from "react-router";
import { Routes } from "react-router";
import { Home } from "./Pages/Home";
import { Route } from "react-router";

function App() {
  return (
    <>
      <Routes>
        <Route element={<Layout />}>
          {/* <Route index element={<Home />} /> */}
          <Route path=":type/:id?" element={<Media />}></Route>
        </Route>
      </Routes>
      {/* <Navbar /> */}
      {/* <Media type={"tv"}></Media> */}
    </>
  );
}

export default App;
