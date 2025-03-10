import axios from "axios";

const baseApiUrl = "http://localhost:8080/api/media";

/**
 *
 * @param {string} type - Type of media to request (tv, movie, anime)
 * @returns {Promise<any>} - Promise response wth data
 */
export const backendGet = async (type, id) => {
  let url = `${baseApiUrl}/${type}${id ? `/${id}` : ""}`;
  try {
    let res = await axios.get(url);
    return res.data;
  } catch (err) {
    if (err.response) {
      if (err.status == 404) {
        throw new TypeError(err.message);
      }
    } else if (err.request) {
      console.log(err.request);
    } else {
      console.log("API ELSE BLOCK");
    }
  }
};
