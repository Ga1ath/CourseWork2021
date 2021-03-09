import { FETCH_ALL, FILTER_POSTS } from '../constants/actionTypes';
// import data from '../data';

import * as api from '../api/index';

export const getPosts = () => async (dispatch) => {
	try {
		const { data } = await api.fetchPosts();

		dispatch({ type: FETCH_ALL, payload: data });
	} catch (error) {
		console.log(error.message);
	}
};

export const filterPosts = (filter) => async (dispatch) => {
	dispatch({ type: FILTER_POSTS, filter: filter });
}