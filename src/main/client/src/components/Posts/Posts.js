import React from 'react';
import Post from './Post/Post';
import Grid from '@material-ui/core/Grid';

import { useSelector } from 'react-redux';

import data from '../../data';

const Posts = () => {

	const posts = data;
	// const posts = useSelector(state => state.posts);

	return (
		<Grid container justify={"center"}>
			{posts.map(post => { return (
				<Grid item xs={12} sm={4} md={3} p={4} style={{padding: "13px"}}>
					<Post key={post.id} post={post}/>
				</Grid>
			)})}
		</Grid>
	)
}

export default Posts;