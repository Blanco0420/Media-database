import { createContext, useContext, useState } from "react";

const FormContext = createContext();

export const useForm = () => useContext(FormContext);

export const FormProvider = ({ children }) => {
  const [formData, setFormData] = useState({
    name: "",
    description: "",
    releaseDate: "",
    personRole: [],
    rating: 0,
  });

  return (
    <FormContext.Provider value={{ formData, setFormData }}>
      {children}
    </FormContext.Provider>
  );
};
