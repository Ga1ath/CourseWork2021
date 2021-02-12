import { FETCH_ALL } from '../constants/actionTypes';

const reducer = (posts = [], action) => {
	switch (action.type) {
		case FETCH_ALL:
			return action.payload;
		default:
			return posts;
	}
}

export default reducer;