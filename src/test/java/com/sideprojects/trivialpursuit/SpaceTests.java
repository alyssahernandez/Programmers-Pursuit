package com.sideprojects.trivialpursuit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpaceTests {
	
	Space centerSpace = new Space(0);
	
	Space node6 = new Space(6);
	Space node30 = new Space(30);
	Space node66 = new Space(66);
	
	Space end12 = new Space(12);
	Space end48 = new Space(48);
	Space end72 = new Space(72);
	
	Space start1 = new Space(1);
	Space start25 = new Space(25);
	Space start61 = new Space(61);
	
	Space spoke4 = new Space(4);
	Space spoke33 = new Space(33);
	Space spoke51 = new Space(51);
	
	
//	TESTS COMMENTED OUT BECAUSE THEY RELY ON MEMBERS THAT HAVE BEEN SET TO 'PRIVATE'
//	@Test
//	public void center_space_adjascents() {
//		
//		List<Integer> expected = new ArrayList<Integer>();
//		expected.add(1);
//		expected.add(13);
//		expected.add(25);
//		expected.add(37);
//		expected.add(49);
//		expected.add(61);
//		
//		List<Integer> actual = centerSpace.adjascentSpaces(centerSpace.getId());
//				
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void node_adjascents() {
//				
//		List<Integer> expected6 = new ArrayList<Integer>();
//		expected6.add(5);
//		expected6.add(7);
//		expected6.add(72);
//		
//		List<Integer> expected30 = new ArrayList<Integer>();
//		expected30.add(29);
//		expected30.add(31);
//		expected30.add(24);
//
//		
//		List<Integer> expected66 = new ArrayList<Integer>();
//		expected66.add(65);
//		expected66.add(67);
//		expected66.add(60);
//
//		
//		assertEquals(expected6, node6.adjascentSpaces(node6.getId()));
//		assertEquals(expected30, node30.adjascentSpaces(node30.getId()));
//		assertEquals(expected66, node66.adjascentSpaces(node66.getId()));
//		
//	}
//	
//	@Test
//	public void L_end_adjascents() {
//				
//		List<Integer> expected12 = new ArrayList<Integer>();
//		expected12.add(11);
//		expected12.add(18);
//		
//		List<Integer> expected48 = new ArrayList<Integer>();
//		expected48.add(47);
//		expected48.add(54);
//		
//		List<Integer> expected72 = new ArrayList<Integer>();
//		expected72.add(71);
//		expected72.add(6);
//		
//		assertEquals(expected12, end12.adjascentSpaces(end12.getId()));
//		assertEquals(expected48, end48.adjascentSpaces(end48.getId()));
//		assertEquals(expected72, end72.adjascentSpaces(end72.getId()));
//		
//	}
//	
//	@Test
//	public void L_start_adjascents() {
//				
//		List<Integer> expected1 = new ArrayList<Integer>();
//		expected1.add(2);
//		expected1.add(0);
//		
//		List<Integer> expected25 = new ArrayList<Integer>();
//		expected25.add(26);
//		expected25.add(0);
//		
//		List<Integer> expected61 = new ArrayList<Integer>();
//		expected61.add(62);
//		expected61.add(0);
//		
//		assertEquals(expected1, start1.adjascentSpaces(start1.getId()));
//		assertEquals(expected25, start25.adjascentSpaces(start25.getId()));
//		assertEquals(expected61, start61.adjascentSpaces(start61.getId()));
//		
//	}
//	
//	@Test
//	public void spoke_adjascents() {
//				
//		List<Integer> expected4 = new ArrayList<Integer>();
//		expected4.add(3);
//		expected4.add(5);
//		
//		List<Integer> expected33 = new ArrayList<Integer>();
//		expected33.add(32);
//		expected33.add(34);
//		
//		List<Integer> expected51 = new ArrayList<Integer>();
//		expected51.add(50);
//		expected51.add(52);
//		
//		assertEquals(expected4, spoke4.adjascentSpaces(spoke4.getId()));
//		assertEquals(expected33, spoke33.adjascentSpaces(spoke33.getId()));
//		assertEquals(expected51, spoke51.adjascentSpaces(spoke51.getId()));
//		
//	}
	
	@Test
	public void secondary_spaces() {
		
		List<Integer> expectedCenter = new ArrayList<Integer>();
		expectedCenter.add(2);
		expectedCenter.add(14);
		expectedCenter.add(26);
		expectedCenter.add(38);
		expectedCenter.add(50);
		expectedCenter.add(62);
		
		List<Integer> expected30 = new ArrayList<Integer>();
		expected30.add(28);
		expected30.add(32);
		expected30.add(23);
		
		List<Integer> expected48 = new ArrayList<Integer>();
		expected48.add(46);
		expected48.add(53);
		expected48.add(55);
				
		assertEquals(expectedCenter, centerSpace.getReachableSpaces().get(2));
		assertEquals(expected30, node30.getReachableSpaces().get(2));
		assertEquals(expected48, end48.getReachableSpaces().get(2));

	}
	
	@Test
	public void tertiary_spaces() {
		List<Integer> expectedCenter = new ArrayList<Integer>();
		expectedCenter.add(3);
		expectedCenter.add(15);
		expectedCenter.add(27);
		expectedCenter.add(39);
		expectedCenter.add(51);
		expectedCenter.add(63);
		
		List<Integer> expected30 = new ArrayList<Integer>();
		expected30.add(27);
		expected30.add(33);
		expected30.add(22);
		
		assertEquals(expectedCenter, centerSpace.getReachableSpaces().get(3));
		assertEquals(expected30, node30.getReachableSpaces().get(3));

	}
	
	@Test
	public void reachable_spaces() {
		List<Integer> expected4 = new ArrayList<Integer>();
		expected4.add(14);
		expected4.add(26);
		expected4.add(38);
		expected4.add(50);
		expected4.add(62);
		expected4.add(10);
		expected4.add(69);
		
		assertEquals(expected4, spoke4.getReachableSpaces().get(6));
	}
	
}
