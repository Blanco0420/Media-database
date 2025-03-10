import React from "react";
import { PanelTopOpen } from "lucide-react";

export const Navbar = ({ items }) => {
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
            className="menu menu-sm dropdown-content rounded-box mt-3 w-52 p-2 shadow"
          >
            {items.map((item, index) =>
              item.submenu ? (
                <li key={index}>
                  <a>{item.label}</a>
                  <ul className="p-2">
                    {item.submenu.map((subItem, subIndex) => (
                      <li key={subIndex}>
                        <a>{subItem.label}</a>
                      </li>
                    ))}
                  </ul>
                </li>
              ) : (
                <li key={index}>
                  <a>{item.label}</a>
                </li>
              )
            )}
          </ul>
        </div>
        <a className="btn btn-ghost text-xl">Media Database</a>
        {/* </div> */}

        {/* Center: Desktop Horizontal Menu */}
        {/* <div className="navbar-center hidden lg:flex"> */}
        <ul className="menu hidden lg:flex menu-horizontal z-1 px-1">
          {items.map((item, index) =>
            item.submenu ? (
              <li key={index}>
                <details>
                  <summary>{item.label}</summary>
                  <ul className="p-2">
                    {item.submenu.map((subItem, subIndex) => (
                      <li key={subIndex}>
                        <a>{subItem.label}</a>
                      </li>
                    ))}
                  </ul>
                </details>
              </li>
            ) : (
              <li key={index}>
                <a>{item.label}</a>
              </li>
            )
          )}
        </ul>
      </div>

      {/* Right Side: Button */}
      {/* <div className="navbar-end">
        <a className="btn">Button</a> */}
      {/* </div> */}
    </div>
  );
};
