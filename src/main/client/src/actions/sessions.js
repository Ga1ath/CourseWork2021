import { FETCH_SESSIONS } from '../constants/actionTypes';

import * as api from '../api/index';

export const getSessions = (filmId) => async (dispatch) => {
  try {
    const { data } =  await api.fetchSessions(filmId);

    dispatch({ type: FETCH_SESSIONS, payload: data })
  } catch (err) {
    console.log(err);
  }
}