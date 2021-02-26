import { FETCH_ALL, FILTER_POSTS } from '../constants/actionTypes';

const reducer = (posts = [], action) => {
	switch (action.type) {
		case FETCH_ALL:
			return action.payload;
		case FILTER_POSTS:
			return posts.filter(post => post.name.includes(action?.filter));
		default:
			return posts;
	}
}

export default reducer;