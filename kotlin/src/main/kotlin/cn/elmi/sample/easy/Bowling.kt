package cn.elmi.sample.easy

/*
   保龄球的一局称为一个frame，一共有10局。
   第1到9局，一般每局可以投掷（roll）两次，但是有一个例外，就是第一次投掷就全中 - 这种情况称为strike，打出strike后这一局就算结束，不再投掷第二次。还有一种情况是补中，即第一次投掷没有全中，但第二次投掷把剩下的球都打倒了 - 这种情况称为spare。
   第10局，如果第一次投掷strike，则再奖励（bonus）两次投掷。如果经历两次投掷打出spare，则再奖励一次投掷。否则就是两次投掷结束。
   计分时，如果这一局两次投掷也未全中，直接记分如“43”。如果打出strike，记为“X”，且该局的分数为本来的10分，加上下两次投掷的分数。如果打出spare，记为“4/”（假设第一次投掷击中4个球），且该局的分数为10分加上下一次投掷的分数。
 */
class Bowling(
    private val frames: List<Frame>
)

class Frame {

    fun roll() = 0

    fun strick() = 10
}
