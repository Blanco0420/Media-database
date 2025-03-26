import React from "react";
import { PanelTopOpen } from "lucide-react";
import { Link, NavLink } from "react-router";
import { useState } from "react";

export const Navbar = ({ items }) => {
  const [isOpen, setIsOpen] = useState(false);
  const handleDropdown = () => {
    console.log(`before ${isOpen}`);
    setIsOpen(isOpen ? false : true);
    console.log(`after ${isOpen}`);
  };
  return (
    <div className="navbar shadow-sm">
      {/* Left Side: Mobile Dropdown Menu */}
      <div className="navbar-start">
        <div className="dropdown">
          <div tabIndex={0} role="button" className="btn btn-ghost lg:hidden">
            <PanelTopOpen />
          </div>
          <ul
            tabIndex={0}
            className="menu menu-sm dropdown-content rounded-box z-1 mt-3 w-52 p-2 shadow"
          >
            {items.map((item, index) =>
              item.submenu ? (
                <li key={index}>
                  <a>{item.label}</a>
                  <ul className="p-2">
                    {item.submenu.map((subItem, subIndex) => (
                      <li key={subIndex}>
                        <NavLink to={subItem.dest}>{subItem.label}</NavLink>
                      </li>
                    ))}
                  </ul>
                </li>
              ) : (
                <li key={index}>
                  <NavLink to={item.dest}>{item.label}</NavLink>
                </li>
              )
            )}
          </ul>
        </div>
        <Link to={"/"} className="btn btn-ghost text-xl">
          Media Database
        </Link>
        {/* </div> */}

        {/* Center: Desktop Horizontal Menu */}
        <div className=" navbar-center hidden lg:flex">
          <ul
            tabIndex={0}
            className="menu dropdown-content menu-horizontal z-1 px-1"
          >
            {items.map((item, index) =>
              item.submenu ? (
                <li key={index}>
                  <details
                    open={isOpen}
                    onClick={(e) => {
                      e.preventDefault();
                      handleDropdown();
                    }}
                  >
                    <summary>{item.label}</summary>
                    <ul className="p-2">
                      {item.submenu.map((subItem, subIndex) => (
                        <li
                          onClick={() => handleDropdown(index)}
                          key={subIndex}
                        >
                          <NavLink to={subItem.dest}>{subItem.label}</NavLink>
                        </li>
                      ))}
                    </ul>
                  </details>
                </li>
              ) : (
                <li key={index}>
                  <NavLink to={item.dest}>{item.label}</NavLink>
                </li>
              )
            )}
          </ul>
        </div>

        {/* Right Side: Button */}
        {/* <div className="navbar-end">
        <a className="btn">Button</a> */}
      </div>
    </div>
  );
};
