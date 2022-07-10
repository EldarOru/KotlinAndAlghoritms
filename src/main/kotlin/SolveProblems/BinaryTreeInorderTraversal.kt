package SolveProblems

import java.util.*
import kotlin.collections.ArrayList

class BinaryTreeInorderTraversal {
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun inorderTraversal(root: TreeNode?): List<Int> {
    var rt = root
    val stack = Stack<TreeNode?>()
    val result = ArrayList<Int>()
    while(rt != null || !stack.isEmpty()){
        while(rt != null){
            stack.push(rt)
            rt = rt.left
        }
        if(!stack.isEmpty()){
            stack.pop()
            rt?.`val`?.let { result.add(it) }
            rt = rt?.left
        }
    }
    return result
}

fun main(){
    var ti = TreeNode(5)
    var v = ti.`val`
}