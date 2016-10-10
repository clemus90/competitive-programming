"use strict";

class Node{
  constructor(data, next_node){
    this.data = data || null;
    this.next = next_node || null;
  }
}

class LinkedList{
  constructor(head){
    this.head = head || null;
  }

  append(node){
    let currNode = this.head;
    if(this.head == null){
      this.head = node;
      return;
    }
    while(currNode.next != null){
      currNode = currNode.next;
    }
    currNode.next = node;
  }

  prepend(node){
    node.next = this.head;
    this.head = node.next;
  }
}


function has_cycle(linkedList){
  let visited = [];
  let currentPos = linkedList.head;
  while(currentPos != null){
    if(visited.indexOf(currentPos) != -1){
      return true;
    }else{
      visited.push(currentPos);
      currentPos = currentPos.next;
    }
  }
  return false;
}