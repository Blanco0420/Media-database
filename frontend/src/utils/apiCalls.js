import axios from "axios";

const baseApiUrl = "http://192.168.0.8:8080";
const headers = {
  "x-api-key": "my-api-key",
}


/**
 *
 * @param {string} type - Type of media to request (tv, movie, anime)
 * @returns {Promise<any>} - Promise response wth data
 */
export const backendGetMedia = async (type, id) => {
  let url = `${baseApiUrl}/api/media/${type}${id ? `/${id}` : ""}`;
  try {
    let res = await axios.get(url, {
      headers: headers
    });
    return res.data;
  } catch (err) {
    if (err.response) {
      if (err.response.status == 404) {
        throw new TypeError(err.message);
      }
    } else if (err.request) {
      console.log(err.request);
    } else {
      console.error("API ELSE BLOCK");
    }
  }
};

export const backendGetPeople = async ({ role }) => {
  let url = `${baseApiUrl}/api/person${role ? `?role=${role}` : ""}`;
  let res = await axios.get(url, {
    headers: headers
  });
  return res.data;
};

export const backendPostMedia = async (type, mediaItem) => {
  let url = `${baseApiUrl}/api/media/${type}/new`;
  console.log(await axios.post(url, mediaItem, {
    headers: headers
  }));
};

export const updateValue = (id, field) => {};
