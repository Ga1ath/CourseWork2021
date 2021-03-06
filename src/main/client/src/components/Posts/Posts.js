import React from 'react';
import Post from './Post/Post';
import Grid from '@material-ui/core/Grid';

import { useSelector } from 'react-redux';
import useStyles from './styles';

import data from '../../data';

const Posts = ({ posts }) => {
	const classes = useStyles();
	//console.log(posts);
	//const posts = useSelector(state => state.posts);

	return (
		<Grid container justify={"flex-start"} className={classes.containerGrid}>
			{posts.map(post => { return (
				<Grid item xs={12} sm={4} md={3} lg={2} p={4} style={{padding: "10px"}} key={post.id}>
					<Post post={post}/>
				</Grid>
			)})}
		</Grid>
	)
}

export default Posts;