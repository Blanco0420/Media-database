import { Minus } from "lucide-react";
import { Plus } from "lucide-react";
import React from "react";

const PersonButton = ({ person, onClick, children }) => {
  // console.log(person);
  return (
    <button key={person.id} onClickCapture={() => onClick(person)}>
      <li className="list-row transition-colors hover:bg-base-200">
        <div>
          {person.firstName} {person.lastName}
        </div>
        <div></div>
        {children}
      </li>
    </button>
  );
};

const togglePerson = (
  person,
  sourceList,
  setSourceList,
  targetList,
  setTargetList
) => {
  setSourceList(sourceList.filter((p) => p.id !== person.id));
  setTargetList([...targetList, person]);
};

export const FilteredPeople = ({
  people,
  setPeople,
  unfilteredPeople,
  setUnfilteredPeople,
}) => {
  return (
    <div className="p-3 outline-1 min-w-sm">
      <h4>Filtered People</h4>
      <ul className="list">
        {people.length >= 1 ? (
          people.map((person) => (
            <PersonButton
              key={person.id}
              onClick={() =>
                togglePerson(
                  person,
                  people,
                  setPeople,
                  unfilteredPeople,
                  setUnfilteredPeople
                )
              }
              person={person}
            >
              <Minus />
            </PersonButton>
          ))
        ) : (
          <div></div>
        )}
      </ul>
    </div>
  );
};

export const UnfilteredPeople = ({
  people,
  setPeople,
  filteredPeople,
  setFilteredPeople,
}) => {
  // const handleDeselectPerson = (person) => {
  //   setFilteredPeople(filteredPeople.filter((p) => p.id !== person.id));
  //   setPeople([...people, person]);
  // };

  return (
    <div className="p-3 outline-1 min-w-sm">
      <h4>Unfiltered People</h4>
      <ul className="list">
        {people.length >= 1 ? (
          people.map((person) => (
            <PersonButton
              key={person.id}
              person={person}
              onClick={() =>
                togglePerson(
                  person,
                  people,
                  setPeople,
                  filteredPeople,
                  setFilteredPeople
                )
              }
            >
              <Plus />
            </PersonButton>
          ))
        ) : (
          <div></div>
        )}
      </ul>
    </div>
  );
};
